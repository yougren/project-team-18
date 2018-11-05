package controllers;

import com.google.inject.Singleton;
import cs361.battleships.models.Dock;
import ninja.Context;
import ninja.Result;
import ninja.Results;
import cs361.battleships.models.Game;
import cs361.battleships.models.Ship;
import cs361.battleships.models.Battleship;
import cs361.battleships.models.Destroyer;
import cs361.battleships.models.Minesweeper;

@Singleton
public class ApplicationController {

    Dock dock = new Dock();

    public Result index() {
        return Results.html();
    }

    public Result newGame() {
        Game g = new Game();
        this.dock.registerClass("BATTLESHIP", Battleship.class);
        this.dock.registerClass("DESTROYER", Destroyer.class);
        this.dock.registerClass("MINESWEEPER", Minesweeper.class);
        return Results.json().render(g);
    }

    public Result placeShip(Context context, PlacementGameAction g) {
        Game game = g.getGame();
        Ship playerShip, aiShip;

        try {
            playerShip = this.dock.deploy(g.getShipType());
            aiShip = this.dock.deploy(g.getShipType());
        } catch (InstantiationException e) {
            System.err.println("Critical error, could not instantiate new ships:" + e);
            return Results.badRequest();
        }

        boolean placeSuccess = game.placeShip(playerShip, g.getActionRow(), g.getActionColumn(), g.isVertical());
        if (placeSuccess) {
            game.placeShip(aiShip);
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }

    public Result attack(Context context, AttackGameAction g) {
        Game game = g.getGame();
        boolean attackSuccess = game.attack(g.getActionRow(), g.getActionColumn());
        if (attackSuccess) {
            game.attack();
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }
}
