package com.rascarlo.simpletile;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

public class TileB extends TileService {

    protected static boolean isTileActive = false;

    @Override
    public void onStartListening() {
        updateTileResources();
        super.onStartListening();
    }

    private void updateTileResources() {
        if (this.getQsTile() != null) {
            Tile tile = this.getQsTile();
            tile.setLabel(String.format(getString(R.string.formatted_tile_b_label),
                    isTileActive ? getString(R.string.active) : getString(R.string.inactive)));
            tile.setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_android_white_24dp));
            tile.setState(isTileActive ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
            tile.updateTile();
        }
    }

    @Override
    public void onClick() {
        TileB.this.startActivityAndCollapse(new Intent(getApplicationContext(), MainActivity.class));
        super.onClick();
    }
}
