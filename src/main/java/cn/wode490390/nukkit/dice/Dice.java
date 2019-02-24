package cn.wode490390.nukkit.dice;

import cn.nukkit.plugin.PluginBase;

public class Dice extends PluginBase {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        long max = 6;
        String t = "max";
        try {
            max = this.getConfig().getLong(t);
        } catch (Exception e) {
            this.logLoadException(t);
        }
        if (max < 2) {
            this.getLogger().alert("The maximum value must be greater than 1.");
            max = 2;
        }
        String msg = "&9[Dice] &8&o%PLAYER% rolled %RESULT%";
        t = "msg";
        try {
            msg = this.getConfig().getString(t);
        } catch (Exception e) {
            this.logLoadException(t);
        }
        this.getServer().getCommandMap().register("dice", new DiceCommand(this, max, msg));
        new MetricsLite(this);
    }

    private void logLoadException(String t) {
        this.getLogger().alert("An error occurred while reading the configuration '" + t + "'. Use the default value.");
    }
}
