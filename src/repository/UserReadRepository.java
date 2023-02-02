package repository;

import query.UserAddress;
import query.UserContact;

import java.util.HashMap;
import java.util.Map;

public class UserReadRepository {
    private Map<String, UserAddress> userAddress = new HashMap<>();
    private Map<String, UserContact> userContact = new HashMap<>();

    public UserAddress getUserAddress(String userId) {
        return userAddress.get(userId);
    }
    public void setUserAddress(Map<String, UserAddress> userAddress) {
        this.userAddress = userAddress;
    }

    public UserContact getUserContact(String userId) {
        return userContact.get(userId);
    }

    public void setUserContact(Map<String, UserContact> userContact) {
        this.userContact = userContact;
    }

    public void addUserContact(String userid, UserContact userContact) {
        this.userContact.put(userid, userContact);
    }
    
    public void addUserAddress(String userid, UserAddress userAddress) {
        this.userAddress.put(userid, userAddress);
    }
}
