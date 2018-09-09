package com.jonzarate.fanduelgame.data.source.local;

import android.arch.persistence.room.Room;
import android.content.Context;

public class RoomSetup {

    public static NbaDb nbaDb;

    public static void init(Context context) {
        nbaDb = Room.databaseBuilder(context, NbaDb.class, "bna_database").build();
    }

}
