package org.moji.backend.dto.response;

import lombok.Data;

@Data
public class RefreshData {
    private String accessToken;

    public RefreshData(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() { return accessToken; }
}
