package com.example.bank.models;

/**
 * Вспомогательный класс для операций, хранящий денежные средства, которые собираются использовать (снять или внести)
 */
public class Money {
    public Long add;
    public Long sub;

    public Long getAdd() {
        return add;
    }

    public Long getSub() {
        return sub;
    }

    public void setAdd(Long add) {
        this.add = add;
    }

    public void setSub(Long sub) {
        this.sub = sub;
    }

}
