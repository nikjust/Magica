public static class Modeljeffph02 extends EntityModel {
	private final ModelRenderer RightArm;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modeljeffph02() {
		textureWidth = 128;
		textureHeight = 128;

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-7.0F, -6.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 106, -5.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -8.0F, -6.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 32, -6.0F, -8.0F, -3.0F, 12, 16, 6, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-3.0F, 10.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 104, 0, -3.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(3.0F, 10.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 104, 0, -3.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		RightArm.render(f5);
		Head.render(f5);
		Body.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}