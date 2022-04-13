package com.dbc.kafkachat.userenum;

public enum Users {
    GERAL("chat-geral"),
    ANA("chat-ana"),
    EZEQUIAS("chat-ezequias"),
    FLAVIO("chat-flavio"),
    FELIPE("chat-felipe"),
    GABRIEL("chat-gabriel"),
    GUILHERME("chat-guilherme"),
    GUSTAVO("chat-gustavo"),
    JOAO("chat-joao"),
    LUCAS("chat-lucas"),
    LUIZ("chat-luiz"),
    MAICON("chat-maicon"),
    NICOLAS("chat-nicolas"),
    PABLO("chat-pablo");

    private String name;

    Users(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
