# Jump hack

## Background
When the player jumps, their y-velocity is set to a specific amount.
When the jump boost potion effect is active, this amount is increased.

## Goal
`.jump 3.0` -> increase jump velocity by a factor of 3 (will cause player to jump 9 times higher)

## Hint
`LivingEntity.java jump() function`

## Code
<details>
  <summary>Possible solution</summary>
<p>

### `Hacks.java`
```java
public static float jumpMultiplier = 1;

/**
 * Modify the y-velocity of a jump
 * @param entity jumping entity
 * @param verticalImpulse y-velocity after jump boost calculation
 * @return modified y-velocity
 * */
public static float jumpUpwardsMotion(LivingEntity entity, float verticalImpulse) {
    if (entity == Minecraft.getInstance().player) {
        return verticalImpulse * jumpMultiplier;
    } else {
        // don't boost jumps of pigs, cows, chickens, etc.
        return verticalImpulse;
    }
}

public static boolean chatMessageHook(String message) {
    // ...
        else if (args[0].equals(".jump")) {
            try {
                jumpMultiplier = Float.parseFloat(args[1]);
            } catch (NumberFormatException e) {
                // if not a number, turn off jump hack
                jumpMultiplier = 1;
            }
            chat("jump multiplier=" + jumpMultiplier);
        }
    // ...
}
```

### `LivingEntity.java`
```java
protected void jump() {
    // ...

    if (this.isPotionActive(Effects.JUMP_BOOST))
    {
    f += 0.1F * (float)(this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1);
    }

    // hacks here: intercept jump y-velocity
    f = hacks.Hacks.jumpUpwardsMotion(this, f);

    Vector3d vector3d = this.getMotion();
    this.setMotion(vector3d.x, (double)f, vector3d.z);
    
    // ...
}
```

</p>
</details>

## Expand
- super jump key, when pressed causes the player to jump 10 blocks high
