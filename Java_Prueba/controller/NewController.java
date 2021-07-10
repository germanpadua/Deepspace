/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.DeepSpaceView;
import View.GUI.NewMainView;
import deepspace.Dice;
import deepspace.EnemyStarShip;
import deepspace.GameUniverse;
import deepspace.NewGame;
import deepspace.SpaceFighter;
import deepspace.SpaceStation;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author germanpadua
 */
public class NewController {
    private static final NewController instance = new NewController();
    
    private NewGame game;
    private  NewMainView view;

    
    private NewController () {}
    
    public static NewController getInstance() {
      return instance;
    }
    
    public void setModelView (NewGame aGame, NewMainView aView) {
      game = aGame;
      view = aView;
    }
    
    public void start() {
        
        view.updateView();
        view.showView();
    }
    
    public NewGame getGame(){
        return game;
    }
    
    public int stationSize(){
        return game.stationsSize();
    }
    
    public ArrayList<SpaceFighter> getArray(){
        return game.getArray();
    }
    
    public void addNewSpaceFighter(){
        String name = "Anonimo";
        game.addSpaceFighter(name);
    }
    public void finish (int i) {
        System.exit(i);    
    }
    
    private void invertArray (ArrayList<Integer> array) {
      int i, n;
      
      n = array.size();
      for (i = 0; i < n/2; i++)
        Collections.swap(array, i, n-i-1);
    }
    
    public void deleteSelected(ArrayList<Integer> selected){
        invertArray(selected);
        
        for (int i : selected) {
          game.deleteSpaceFighter(i);
        }  
    }
}
