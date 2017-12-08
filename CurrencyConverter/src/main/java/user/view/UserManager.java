/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.view;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Perttu Jääskeläinen
 */
@Named("userManager")
@ConversationScoped
public class UserManager implements Serializable {
    @Inject
    private Conversation conversation;
    private String userID = "1";
    private String toUpdate = null;
    private boolean started = false;
    
    public UserManager() {   
    }
    
    public boolean getStarted() {
        return this.started;
    }
    public boolean setStarted() {
        return false;
    }
    
    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String ID) {
        this.userID = ID;
    }
    public void setUpdatedUser(String user) {
        this.toUpdate = user;
    }
    public String getUpdatedUser() {
        return null;
    }
    public void updateUser() {
        if (this.toUpdate != null) {
            return;
        }
        setUserID(this.toUpdate);
        this.toUpdate = null;
    }
    public void removeUser() {
        if (this.toUpdate == null) {
            return;
        }
        setUserID(null);
    }
    /**
     * Start a EJB session bean
     */
    public void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
            this.started = true;
        }
    }
    /**
     * End the EJB session bean
     */
    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
            this.started = false;
        }
    }
}
