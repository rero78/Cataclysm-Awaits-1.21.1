package net.foxtrot.cataclysmawaits.client.renderer;

import net.foxtrot.cataclysmawaits.block.entity.SpecialFrogBlockEntity;
import net.foxtrot.cataclysmawaits.client.model.SpecialFrogModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SpecialFrogRenderer extends GeoBlockRenderer<SpecialFrogBlockEntity> {
    public SpecialFrogRenderer() {
        super(new SpecialFrogModel());
    }

}
