package com.example.calcul_mental.models;

public class CalculateModel {
    private int _firstValue;
    private int _secondValue;
    private String _operator;

    public CalculateModel(int _firstValue, int _secondValue, String _operator){
        this._firstValue=_firstValue;
        this._secondValue=_secondValue;
        this._operator=_operator;
    }

    public int getFirstValue() {
        return _firstValue;
    }

    public int getSecondValue() {
        return _secondValue;
    }

    public String getOperator() {
        return _operator;
    }
}
