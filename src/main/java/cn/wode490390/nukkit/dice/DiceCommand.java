package cn.wode490390.nukkit.dice;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import java.util.concurrent.ThreadLocalRandom;

public class DiceCommand extends Command {

    private final Dice plugin;
    private final long max;
    private final String msg;

    public DiceCommand(Dice plugin, long max, String msg) {
        super("dice", "Roll dice", "/dice", new String[]{"roll"});
        this.setPermission("dice.command");
        this.commandParameters.clear();
        this.plugin = plugin;
        this.max = max;
        this.msg = msg;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!this.plugin.isEnabled()) {
            return false;
        }
        if (!this.testPermission(sender)) {
            return true;
        }
        this.plugin.getServer().broadcastMessage(TextFormat.colorize(this.msg
                .replace("%PLAYER%", sender.getName())
                .replace("%RESULT%", String.valueOf(ThreadLocalRandom.current().nextLong(1, this.max)))
        ));
        return true;
    }
}
