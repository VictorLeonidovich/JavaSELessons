/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotsgameworld.utils;

import javax.faces.bean.SessionScoped;

/**
 *
 * @author Victor
 */
@SessionScoped
public enum TaskContent {
    BUILD("Build"),
    DEFEND("Defend"),
    FIRE("Fire"),
    REPAIR("Repair"),
    SCOUT("Scout"),
    KILLYOURSELF("Kill yourself");
    
    private String taskContent;

    private TaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskContent() {
        return taskContent;
    }

    @Override
    public String toString() {
        return taskContent;
    }
}
