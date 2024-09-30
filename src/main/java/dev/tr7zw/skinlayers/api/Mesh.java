package dev.tr7zw.skinlayers.api;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
// spotless:off
//#if MC >= 11700
import net.minecraft.client.model.geom.PartPose;
//#endif
//spotless:on

public interface Mesh {

    public static final Mesh EMPTY = new Mesh() {

        @Override
        public void setVisible(boolean visible) {
        }

        @Override
        public void setRotation(float xRot, float yRot, float zRot) {
        }

        @Override
        public void setPosition(float x, float y, float z) {
        }

        @Override
        public void render(ModelPart vanillaModel, PoseStack poseStack, VertexConsumer vertexConsumer, int light,
                int overlay, int color) {
        }

        @Override
        // spotless:off
        //#if MC >= 11700
        public void loadPose(PartPose partPose) {
        //#else
          //$$ public void loadPose(ModelPart partPose) {
        //#endif
        //spotless:on
        }

        @Override
        public boolean isVisible() {
            return false;
        }

        @Override
        public void copyFrom(ModelPart modelPart) {
        }

        @Override
        public void reset() {
        }
    };

    public default void render(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay) {
        render(null, poseStack, vertexConsumer, light, overlay, 0xFFFFFFFF);
    }

    /**
     * @param color The color, in ARGB format
     */
    public void render(ModelPart vanillaModel, PoseStack poseStack, VertexConsumer vertexConsumer, int light,
            int overlay, int color);

    public void setPosition(float x, float y, float z);

    public void setRotation(float xRot, float yRot, float zRot);

    // spotless:off
    //#if MC >= 11700
    public void loadPose(PartPose partPose);
    //#else
      //$$ public void loadPose(ModelPart partPose);
    //#endif
    //spotless:on

    public void copyFrom(ModelPart modelPart);
    
    public void reset();

    public void setVisible(boolean visible);

    public boolean isVisible();

}
