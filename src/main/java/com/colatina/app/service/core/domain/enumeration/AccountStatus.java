package com.colatina.app.service.core.domain.enumeration;

public enum AccountStatus {
    ACTIVE{
        @Override
        public boolean isActive() {
            return true;

        }
    }
    , INACTIVE, BLOCKED;

    public boolean isActive(){
        return false;
    }
}
