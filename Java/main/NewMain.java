/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import View.DeepSpaceView;
import View.GUI.NewMainView;
import View.UI.TextMainView;
import controller.Controller;
import controller.NewController;
import deepspace.GameUniverse;
import deepspace.NewGame;

/**
 *
 * @author germanpadua
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      NewMainView ui;
      NewGame game = new NewGame();
      ui = NewMainView.getInstance();
      NewController controller = NewController.getInstance();
      controller.setModelView(game,ui);
      controller.start();   
    }
    
}
