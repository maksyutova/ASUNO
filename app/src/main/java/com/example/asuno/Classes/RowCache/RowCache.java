package com.example.asuno.Classes.RowCache;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RowCache {
    //--------------Set
    @SerializedName("filter")
    @Expose
    public RowCacheFilter filter;

    public void setFolderId(String folderId) {
        RowCacheFilter filter = new RowCacheFilter();
        if(folderId != ""){
            filter.setFolderId(folderId);
        }

        this.filter = filter;
    }
    //--------------Get
    @SerializedName("rows")
    @Expose
    public RowFromRowCache[] rows;

    public RowFromRowCache[] getRows() {
        return rows;
    }
}

class RowCacheFilter{

    @SerializedName("folderId")
    @Expose
    public String folderId;

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }
}
