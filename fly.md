# Fly hack

## Background
In creative mode, double-tapping space bar toggles flight.
We can modify the code so that in any game mode, including survival, we can toggle flight.

## Goal
`.fly on` -> allowing flying in survival mode by double-tapping space

## Hint
`allowFlying` in `ClientPlayerEntity.java`

## Code
<details>
  <summary>Possible solution</summary>
<p>

### `Hacks.java`
```java
public static boolean chatMessageHook(String message) {
    // ...
        else if (args[0].equals(".fly")) {
            boolean flyHackEnabled = args[1].equals("on");
            Minecraft.getInstance().player.abilities.allowFlying = flyHackEnabled;
            chat("fly=" + flyHackEnabled);
        }    
    // ...
}

```

</p>
</details>

## Expand
- persist setting after dying and respawning