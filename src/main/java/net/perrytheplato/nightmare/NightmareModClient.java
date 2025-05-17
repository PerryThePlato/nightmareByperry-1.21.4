package net.perrytheplato.nightmare;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.perrytheplato.nightmare.entity.ModEntities;
import net.perrytheplato.nightmare.entity.client.LurkerModel;
import net.perrytheplato.nightmare.entity.client.LurkerRenderer;


public class NightmareModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        EntityModelLayerRegistry.registerModelLayer(LurkerModel.LURKER, LurkerModel::getTexturedModelData);

        // Then register the renderer
        EntityRendererRegistry.register(ModEntities.LURKER, LurkerRenderer::new);


    }
}