package net.perrytheplato.nightmare.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.*;
import net.minecraft.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.perrytheplato.nightmare.NightmareMod;
import net.perrytheplato.nightmare.item.ModItems;
import net.minecraft.entity.attribute.EntityAttributes;

public class LurkerEntity extends PathAwareEntity {
    public LurkerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState walkAnimationState = new AnimationState();
    private int walkAnimationTimeout = 0;



    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 18)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.ATTACK_DAMAGE, 1)
                .add(EntityAttributes.FOLLOW_RANGE, 20)
                .add(EntityAttributes.TEMPT_RANGE, 20)
                .add(EntityAttributes.JUMP_STRENGTH, 0)
                .add(EntityAttributes.MOVEMENT_EFFICIENCY, 1);
    }

    @Override
    protected void initGoals() {

        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(ModItems.MAGNETITE), false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));



    }




    protected EntityDimensions getDefaultDimensions() {
        return EntityDimensions.fixed(1.85F, 0.75F); // width, height — adjust as needed
    }
    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
            ;
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);

        } else {
            --this.idleAnimationTimeout;
        }

        if (this.walkAnimationTimeout <= 0) {
            this.walkAnimationTimeout = 40;
            this.walkAnimationState.start(this.age);

        } else {
            --this.walkAnimationTimeout;
        }

    }

    public int getWalkAnimationTimeout() {
        return walkAnimationTimeout;
    }

    public void setWalkAnimationTimeout(int walkAnimationTimeout) {
        this.walkAnimationTimeout = walkAnimationTimeout;
    }
}
