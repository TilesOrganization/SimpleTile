package com.rascarlo.simpletile;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class TileA extends TileService {


    private boolean isTileActive = false;

    @Override
    public void onStartListening() {
        updateTileResources();
        super.onStartListening();
    }

    private void updateTileResources() {
        if (this.getQsTile() != null) {
            Tile tile = this.getQsTile();
            tile.setLabel(String.format(getString(R.string.formatted_tile_a_label),
                    isTileActive ? getString(R.string.active) : getString(R.string.inactive)));
            tile.setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.ic_android_white_24dp));
            tile.setState(isTileActive ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
            tile.updateTile();
        }
    }

    @Override
    public void onClick() {
        isTileActive = !isTileActive;
        updateTileResources();
        super.onClick();
    }
}
