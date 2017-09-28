package com.artyombash.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.artyombash.data.cache.Cache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link DataStore}.
 */
@Singleton
public class DataStoreFactory {

    private final Cache cache;
    private final CloudDataStore cloudDataStore;

    @Inject
    public DataStoreFactory(@NonNull Cache cache, CloudDataStore cloudDataStore) {
        this.cache = cache;
        this.cloudDataStore = cloudDataStore;
    }

    /**
     * Create {@link DataStore} from a competition id.
     */
    public DataStore create(String id) {
        DataStore userDataStore;

        if (this.cache.isCached(id) && !this.cache.isExpired(id)) {
            userDataStore = new DiskDataStore(this.cache);
            Log.e("Factory", "DISK");
        } else {
            userDataStore = getCloudDataStore();
            Log.e("Factory", "CLOUD");
        }

        return userDataStore;
    }

    /**
     * Get {@link DataStore} to retrieve data from the Cloud.
     */
    public CloudDataStore getCloudDataStore() {
        return cloudDataStore;
    }

}
