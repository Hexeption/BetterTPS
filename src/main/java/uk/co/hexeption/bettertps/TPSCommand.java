package uk.co.hexeption.bettertps;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * TPSCommand
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 09/08/2020 - 09:06 pm
 */
public class TPSCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(
            String.format("%s%s%s-----------%s%s%s<%s%s TPS Graph (48 Seconds) %s%s%s>%s%s%s-----------", ChatColor.GRAY, ChatColor.BOLD, ChatColor.STRIKETHROUGH, ChatColor.DARK_GRAY, ChatColor.BOLD,
                ChatColor.STRIKETHROUGH, ChatColor.GREEN, ChatColor.ITALIC, ChatColor.DARK_GRAY, ChatColor.BOLD, ChatColor.STRIKETHROUGH, ChatColor.GRAY, ChatColor.BOLD, ChatColor.STRIKETHROUGH));
        if (!BetterTPS.lines.isEmpty()) {
            BetterTPS.lines.forEach(sender::sendMessage);
        }
        String status = ChatColor.GRAY + "Unknown";
        ChatColor tpsStatus = ChatColor.GRAY;
        final double currentTPS = BetterTPS.getTPS();
        if (currentTPS >= 17.0) {
            status = ChatColor.GREEN + "STABLE";
            tpsStatus = ChatColor.GREEN;
        } else if (currentTPS >= 15.0) {
            status = ChatColor.YELLOW + "SOME STABILITY ISSUES";
            tpsStatus = ChatColor.YELLOW;
        } else if (currentTPS >= 10.0) {
            status = ChatColor.RED + "LAGGING. CHECK TIMINGS.";
            tpsStatus = ChatColor.RED;
        } else if (currentTPS < 10.0) {
            status = ChatColor.DARK_RED + "UNSTABLE";
            tpsStatus = ChatColor.DARK_RED;
        } else if (currentTPS < 3.0) {
            status = ChatColor.RED + "SEND HELP!!!!!";
            tpsStatus = ChatColor.RED;
        }

        sender.sendMessage(String.format("%s%sServer Status: %s | %s%sTPS: %s", ChatColor.WHITE, ChatColor.BOLD, status, ChatColor.WHITE, ChatColor.BOLD, tpsStatus + "" + currentTPS));
        return true;
    }
}
