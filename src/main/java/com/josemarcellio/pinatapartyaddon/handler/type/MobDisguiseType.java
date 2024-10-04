package com.josemarcellio.pinatapartyaddon.handler.type;

import com.josemarcellio.pinatapartyaddon.handler.IDisguiseType;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import org.bukkit.entity.Entity;

public class MobDisguiseType implements IDisguiseType {

    private final DisguiseType disguiseType;

    public MobDisguiseType(DisguiseType disguiseType) {
        this.disguiseType = disguiseType;
    }

    @Override
    public void disguise(Entity entity) {
        MobDisguise mobDisguise = new MobDisguise(disguiseType);
        mobDisguise.setEntity(entity);
        mobDisguise.startDisguise();
    }
}
