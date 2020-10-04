package com.github.xtralife.leetcode.problems.p65.valid_number.state_machine;

public class Solution {
    enum State {Start, Space, Sign, Dot, DotDigit, Digit, DigitDot, Exponent, ExponentSign, ExponentDigit, EndSpace, Error}

    public boolean isNumber(String s) {
        State state = State.Start;
        for (char ch : s.toCharArray()) {
            if (!isValid(ch)) {
                return false;
            }
            state = nextState(state, ch);
            if (state == State.Error) {
                return false;
            }
        }
        return isValidFinalState(state);
    }

    private State nextState(State state, char ch) {
        switch (state) {
            case Start:
                return afterStart(ch);
            case Space:
                return afterSpace(ch);
            case Sign:
                return afterSign(ch);
            case Dot:
                return afterDot(ch);
            case Digit:
                return afterDigit(ch);
            case DotDigit:
                return afterDotDigit(ch);
            case DigitDot:
                return afterDigitDot(ch);
            case Exponent:
                return afterExponent(ch);
            case ExponentSign:
                return afterExponentSign(ch);
            case ExponentDigit:
                return afterExponentDigit(ch);
            case EndSpace:
                return afterEndSpace(ch);
            default:
                return State.Error;
        }
    }

    private State afterStart(char ch) {
        if (isSpace(ch)) {
            return State.Space;
        }
        if (isSign(ch)) {
            return State.Sign;
        }
        if (isDigit(ch)) {
            return State.Digit;
        }
        if (isDot(ch)) {
            return State.Dot;
        }
        return State.Error;
    }

    private State afterSpace(char ch) {
        if (isSpace(ch)) {
            return State.Space;
        }
        if (isDot(ch)) {
            return State.Dot;
        }
        if (isDigit(ch)) {
            return State.Digit;
        }
        if (isSign(ch)) {
            return State.Sign;
        }
        return State.Error;
    }

    private State afterSign(char ch) {
        if (isDot(ch)) {
            return State.Dot;
        }
        if (isDigit(ch)) {
            return State.Digit;
        }
        return State.Error;
    }

    private State afterDot(char ch) {
        if (isDigit(ch)) {
            return State.DotDigit;
        }
        return State.Error;
    }

    private State afterDigit(char ch) {
        if (isDigit(ch)) {
            return State.Digit;
        }
        if (isDot(ch)) {
            return State.DigitDot;
        }
        if (isExponent(ch)) {
            return State.Exponent;
        }
        if (isSpace(ch)) {
            return State.EndSpace;
        }
        return State.Error;
    }

    private State afterDotDigit(char ch) {
        if (isDigit(ch)) {
            return State.DotDigit;
        }
        if (isExponent(ch)) {
            return State.Exponent;
        }
        if (isSpace(ch)) {
            return State.EndSpace;
        }
        return State.Error;
    }

    private State afterDigitDot(char ch) {
        if (isDigit(ch)) {
            return State.DigitDot;
        }
        if (isExponent(ch)) {
            return State.Exponent;
        }
        if (isSpace(ch)) {
            return State.EndSpace;
        }
        return State.Error;
    }

    private State afterExponent(char ch) {
        if (isDigit(ch)) {
            return State.ExponentDigit;
        }
        if (isSign(ch)) {
            return State.ExponentSign;
        }
        return State.Error;
    }

    private State afterExponentSign(char ch) {
        if (isDigit(ch)) {
            return State.ExponentDigit;
        }
        return State.Error;
    }

    private State afterExponentDigit(char ch) {
        if (isDigit(ch)) {
            return State.ExponentDigit;
        }
        if (isSpace(ch)) {
            return State.EndSpace;
        }
        return State.Error;
    }

    private State afterEndSpace(char ch) {
        if (isSpace(ch)) {
            return State.EndSpace;
        }
        return State.Error;
    }

    private boolean isValid(char ch) {
        return isDigit(ch) || isDot(ch) || isExponent(ch) || isSign(ch) || isSpace(ch);
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isExponent(char ch) {
        return ch == 'e';
    }

    private boolean isSign(char ch) {
        return ch == '-' || ch == '+';
    }

    private boolean isSpace(char ch) {
        return ch == ' ';
    }

    private boolean isDot(char ch) {
        return ch == '.';
    }

    private boolean isValidFinalState(State state) {
        return state == State.Digit
                || state == State.DigitDot
                || state == State.DotDigit
                || state == State.ExponentDigit
                || state == State.EndSpace;
    }
}
