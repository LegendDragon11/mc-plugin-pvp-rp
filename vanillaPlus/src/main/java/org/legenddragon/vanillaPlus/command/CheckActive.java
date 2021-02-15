package org.legenddragon.vanillaPlus.command;

import org.legenddragon.vanillaPlus.vanillaPlus;

public class CheckActive {

    public vanillaPlus plugin;

    public CheckActive(vanillaPlus plugin) {
        this.plugin = plugin;
    }

    // Checks if the Owner set the Command on the Server on
    public boolean check(String command) {
        // Check if command is active
        if ( plugin.ServerConfig.get().isSet("Server.commands." + command) ) {
            return plugin.ServerConfig.get().getBoolean("Server.commands." + command );
        } else {
            Setdefault();
        }
        return false;
    }

    // Setting default
    public void Setdefault() {

        // Setting Commands, ik that this is terrible
        if ( !plugin.ServerConfig.get().isSet("Server.commands.bansystem") ) { plugin.ServerConfig.get().set("Server.commands.bansystem", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.booster") ) { plugin.ServerConfig.get().set("Server.commands.booster", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.ec") ) { plugin.ServerConfig.get().set("Server.commands.ec", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.inv") ) { plugin.ServerConfig.get().set("Server.commands.inv", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.lock") ) { plugin.ServerConfig.get().set("Server.commands.lock", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.pos") ) { plugin.ServerConfig.get().set("Server.commands.pos", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.seed") ) { plugin.ServerConfig.get().set("Server.commands.seed", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.spawn") ) { plugin.ServerConfig.get().set("Server.commands.spawn", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.stats") ) { plugin.ServerConfig.get().set("Server.commands.stats", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.tpa") ) { plugin.ServerConfig.get().set("Server.commands.tpa", false); }
        if ( !plugin.ServerConfig.get().isSet("Server.commands.home") ) { plugin.ServerConfig.get().set("Server.commands.home", false); }

        // Save Changes
        plugin.ServerConfig.save();
    }
}
