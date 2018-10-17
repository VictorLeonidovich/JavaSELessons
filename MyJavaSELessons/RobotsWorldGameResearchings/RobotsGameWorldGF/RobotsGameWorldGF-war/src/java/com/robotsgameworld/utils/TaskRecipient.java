/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotsgameworld.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Victor
 */
@SessionScoped
public enum TaskRecipient {

    BUILDER("Builder"),
    DEFENDER("Defender"),
    FIRER("Firer"),
    REPAIRER("Repairer"),
    SCOUTER("Scouter"),
    ALL("All");
    private String taskRecipient;

    private TaskRecipient(String taskRecipient) {
        this.taskRecipient = taskRecipient;
    }

    public String getTaskRecipient() {
        return taskRecipient;
    }

    @Override
    public String toString() {
        return taskRecipient;
    }

}
