package bingmclobby.Timmety;

import bingmclobby.Timmety.Utils.PlayerManagerUtil;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Data {

    //Server data
    public static int totalPlayer;
    public static ArrayList<Integer> SERVER;

    public static int getTotalPlayer() {
        return totalPlayer;
    }

    public static void setTotalPlayer(int totalPlayer) {
        Data.totalPlayer = totalPlayer;
    }

    public static ArrayList<Integer> getServer() {
        return SERVER;
    }

    public static void setSERVER(ArrayList<Integer> SERVER) {
        Data.SERVER = SERVER;
    }

    //Player data

    public static HashMap<UUID,String> RANK = new HashMap<>();

    //Game data
    public static HashMap<UUID,Integer> TOTAAL_GEWONNEN = new HashMap<>();
    public static HashMap<UUID,Integer> TOTAAL_GESPEELD = new HashMap<>();
    public static HashMap<UUID,Integer> TOTAAL_ITEMS = new HashMap<>();
    public static HashMap<UUID,Integer> GEMIDDELD_ITEMS = new HashMap<>();
    public static HashMap<UUID,Integer> TOTAAL_PLAYTIME = new HashMap<>();
    public static HashMap<UUID,Integer> GEMIDDELDE_PLAYTIME = new HashMap<>();
    public static HashMap<UUID,Integer> EERSTE_GAME = new HashMap<>();


    //Getters

    public static HashMap<UUID, String> getRANK() {
        return RANK;
    }

    public static HashMap<UUID, Integer> getTotaalGewonnen() {
        return TOTAAL_GEWONNEN;
    }

    public static HashMap<UUID, Integer> getTotaalGespeeld() {
        return TOTAAL_GESPEELD;
    }

    public static HashMap<UUID, Integer> getTotaalItems() {
        return TOTAAL_ITEMS;
    }

    public static HashMap<UUID, Integer> getGemiddeldItems() {
        return GEMIDDELD_ITEMS;
    }

    public static HashMap<UUID, Integer> getTotaalPlaytime() {
        return TOTAAL_PLAYTIME;
    }

    public static HashMap<UUID, Integer> getGemiddeldePlaytime() {
        return GEMIDDELDE_PLAYTIME;
    }

    public static HashMap<UUID, Integer> getEersteGame() {
        return EERSTE_GAME;
    }

    //Setters

    public static void setTotaalGewonnen(HashMap<UUID, Integer> totaalGewonnen) {
        TOTAAL_GEWONNEN = totaalGewonnen;
    }

    public static void setTotaalGespeeld(HashMap<UUID, Integer> totaalGespeeld) {
        TOTAAL_GESPEELD = totaalGespeeld;
    }

    public static void setTotaalItems(HashMap<UUID, Integer> totaalItems) {
        TOTAAL_ITEMS = totaalItems;
    }

    public static void setGemiddeldItems(HashMap<UUID, Integer> gemiddeldItems) {
        GEMIDDELD_ITEMS = gemiddeldItems;
    }

    public static void setTotaalPlaytime(HashMap<UUID, Integer> totaalPlaytime) {
        TOTAAL_PLAYTIME = totaalPlaytime;
    }

    public static void setGemiddeldePlaytime(HashMap<UUID, Integer> gemiddeldePlaytime) {
        GEMIDDELDE_PLAYTIME = gemiddeldePlaytime;
    }

    public static void setEersteGame(HashMap<UUID, Integer> eersteGame) {
        EERSTE_GAME = eersteGame;
    }

    public static void setRANK(HashMap<UUID, String> RANK) {
        Data.RANK = RANK;
    }

    public static void saveData(Player player) {

        UUID uuid = player.getUniqueId();

        String rank = PlayerManagerUtil.getRank(player);
        int totaalitems = PlayerManagerUtil.getTotaalItems(player);
        int GemiddeldeItems = PlayerManagerUtil.getGemiddeldItems(player);
        int TotaalGewonnen = PlayerManagerUtil.getTotaalgewonnen(player);
        int TotaalGespeeld = PlayerManagerUtil.getTotaalGespeeld(player);
        int TotaalPlayTime = PlayerManagerUtil.getTotaalPlaytime(player);
        int GemiddeldePlayTime = PlayerManagerUtil.getGemiddeldePlaytime(player);

        HashMap<UUID,String> rankMap = getRANK();
        HashMap<UUID,Integer> TotaalItemsMap = getGemiddeldItems();
        HashMap<UUID,Integer> GemiddelItemsMap = getGemiddeldItems();
        HashMap<UUID,Integer> TotaalGewonnenMap = getTotaalGewonnen();
        HashMap<UUID,Integer> TotaalGespeeldMap = getTotaalGespeeld();
        HashMap<UUID,Integer> TotaalPlayTimeMap = getTotaalPlaytime();
        HashMap<UUID,Integer> GemiddeldPlayTimeMap = getGemiddeldePlaytime();


        rankMap.put(uuid, rank);
        TotaalItemsMap.put(uuid, totaalitems);
        GemiddelItemsMap.put(uuid, GemiddeldeItems);
        TotaalGewonnenMap.put(uuid, TotaalGewonnen);
        TotaalGespeeldMap.put(uuid, TotaalGespeeld);
        TotaalPlayTimeMap.put(uuid, TotaalPlayTime);
        GemiddeldPlayTimeMap.put(uuid, GemiddeldePlayTime);


        setRANK(rankMap);
        setTotaalItems(TotaalItemsMap);
        setGemiddeldItems(GemiddelItemsMap);
        setTotaalGespeeld(TotaalGespeeldMap);
        setTotaalGespeeld(TotaalGespeeldMap);
        setTotaalPlaytime(TotaalPlayTimeMap);
        setGemiddeldePlaytime(GemiddeldPlayTimeMap);
    }
}
