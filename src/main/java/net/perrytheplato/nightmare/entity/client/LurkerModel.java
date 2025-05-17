package net.perrytheplato.nightmare.entity.client;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.CamelAnimations;
import net.minecraft.client.render.entity.model.EntityModel;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.CamelEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.entity.client.state.LurkerRenderState;

public class LurkerModel extends EntityModel<LurkerRenderState>  {
    public static final EntityModelLayer LURKER = new EntityModelLayer(Identifier.of(NightmareMod.MOD_ID, "lurker"), "main");

    protected LurkerModel(ModelPart root) {
        super(root);
    }


    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData lurker = modelPartData.addChild("lurker", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData head = lurker.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -32.0F, -2.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-4.0F, -32.0F, -2.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData body = lurker.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData left_arm = lurker.addChild("left_arm", ModelPartBuilder.create().uv(32, 0).cuboid(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData right_arm = lurker.addChild("right_arm", ModelPartBuilder.create().uv(32, 16).cuboid(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData left_leg = lurker.addChild("left_leg", ModelPartBuilder.create().uv(24, 32).cuboid(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData right_leg = lurker.addChild("right_leg", ModelPartBuilder.create().uv(40, 32).cuboid(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 17.0F, 1.5708F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(LurkerRenderState camelEntityRenderState) {
        super.setAngles(camelEntityRenderState);
        this.setHeadAngles(camelEntityRenderState, camelEntityRenderState.relativeHeadYaw, camelEntityRenderState.pitch);
        this.animateWalking(LurkerAnimations.WALK, camelEntityRenderState.limbSwingAnimationProgress, camelEntityRenderState.limbSwingAmplitude, 2.0F, 2.5F);
        this.animate(camelEntityRenderState.idleAnimationState, LurkerAnimations.IDLE, camelEntityRenderState.age, 1.0F);
    }

    private void setHeadAngles(LurkerRenderState state, float headYaw, float headPitch) {

    }
}




