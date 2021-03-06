package app;

import app.controller.AnnouncementController;
import app.util.Config;

public class XLauncher {
    public static void main(String[] args) throws Exception {

        // Loads values from the properties file
        String channelId    = Config.getInstance().getString("channel_id");
        String username     = Config.getInstance().getString("username");
        String password     = Config.getInstance().getString("password");
        String token        = Config.getInstance().getString("token");

        int interval        = Config.getInstance().getInt("interval");

        BlackboardScraper bs = new BlackboardScraper(username, password);
        AnnouncementController ac = new AnnouncementController(bs, interval);
        DiscordBot db = new DiscordBot(token, channelId, ac);
    }
}
