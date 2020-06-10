public static class Modeljeffph2 extends EntityModel {
	private final ModelRenderer LeftArm;

	public Modeljeffph2() {
		textureWidth = 128;
		textureHeight = 128;

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 16.3333F, 7.0F);
		setRotationAngle(LeftArm, 0.0F, -1.5708F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 96, 91, -12.0F, -4.3333F, 1.0F, 8, 12, 8, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 104, 56, -10.0F, -8.3333F, 2.0F, 6, 16, 6, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 92, 116, -16.0F, 1.6667F, 2.0F, 12, 6, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		LeftArm.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}