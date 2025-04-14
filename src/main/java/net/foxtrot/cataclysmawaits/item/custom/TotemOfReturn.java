package net.foxtrot.cataclysmawaits.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

import java.util.WeakHashMap;

public class TotemOfReturn extends Item {
    public TotemOfReturn(Properties properties) {
        super(properties.stacksTo(1));
    }

    private static final WeakHashMap<ServerPlayer, Long> cooldowns = new WeakHashMap<>();
    private static final long COOLDOWN_DURATION_TICKS = 6000; // 5 minutes

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            long currentTick = serverPlayer.getServer().getTickCount();
            if (cooldowns.containsKey(serverPlayer) && currentTick < cooldowns.get(serverPlayer)) {
                serverPlayer.displayClientMessage(Component.literal("The totem is still recharging..."), true);
                return InteractionResultHolder.fail(stack);
            }

            // Must be full health and full hunger
            if (serverPlayer.getHealth() < serverPlayer.getMaxHealth() || serverPlayer.getFoodData().getFoodLevel() < 20) {
                serverPlayer.displayClientMessage(Component.literal("You must be at full health and hunger to use the totem."), true);
                return InteractionResultHolder.fail(stack);
            }

            BlockPos respawnPos = serverPlayer.getRespawnPosition();
            ResourceKey<Level> respawnDim = serverPlayer.getRespawnDimension();

            ServerLevel worldForSpawn = serverPlayer.server.getLevel(respawnDim);
            BlockPos worldSpawn = worldForSpawn != null ? worldForSpawn.getSharedSpawnPos() : null;

            if (respawnPos != null && respawnDim != null) {

                ServerLevel targetWorld = serverPlayer.server.getLevel(respawnDim);
                if (targetWorld != null && serverPlayer.canChangeDimensions(serverPlayer.level(), targetWorld)) {
                    serverPlayer.teleportTo(targetWorld, respawnPos.getX(), respawnPos.getY(), respawnPos.getZ(), serverPlayer.getYRot(), serverPlayer.getXRot());
                    targetWorld.playSound(null, serverPlayer.blockPosition(), SoundEvents.PORTAL_TRAVEL, SoundSource.PLAYERS, 1.0F, 1.0F);


                    cooldowns.put(serverPlayer, currentTick + COOLDOWN_DURATION_TICKS);
                    return InteractionResultHolder.success(stack);
                }
            }

            serverPlayer.displayClientMessage(Component.literal("You do not have a valid home set..."), true);
            return InteractionResultHolder.fail(stack);
        }
        return InteractionResultHolder.pass(stack);
    }
}
