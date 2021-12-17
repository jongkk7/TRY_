package com.yjk.common.util;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.text.NumberFormat;

public class TTextUtil {

    /**
     * null or empty check
     */
    public boolean isNotEmpty(String data){
        boolean result = false;

        if(data != null && !data.isEmpty()){
            result = true;
        }
        return result;
    }

    /**
     * 특정한 문자열 변경
     * @param changedColor 색 변경
     * @param isBold       굵게 처리
     * @parma txt 변경하고 싶은 문자열
     */
    public static void convertSpecificText(TextView textView, int changedColor, boolean isBold, String... strList) {

        try {

            if (textView == null) {
                return;
            }

            String content = textView.getText().toString();
            SpannableStringBuilder ssb = new SpannableStringBuilder(content);

            textView.setTypeface(null, Typeface.NORMAL);

            for (String str : strList) {

                int startIndex = content.indexOf(str);
                int endIndex = startIndex + str.length();

                if (startIndex >= 0) {

                    ssb.setSpan(new ForegroundColorSpan(changedColor), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    if (isBold) {
                        ssb.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }

                }
            }

            textView.setText(ssb);

        } catch (Exception e) {
            TLog.e(e);
        }
    }

    /**
     * 언더라인 추가
     */
    public static void setUnderLine(TextView textView) {

        if (textView != null) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }
    }

    /**
     * 취소선
     */
    public static void setCancelLine(TextView textView, boolean isCancel){
        if(isCancel) {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            textView.setPaintFlags(0);
        }
    }

    /**
     * 키보드 숨기기
     */
    public static void hideSoftKeyboard(Activity activity) {

        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            //Find the currently focused view, so we can grab the correct window token from it.
            View view = activity.getCurrentFocus();
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = new View(activity);
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 키보드 숨기기
     */
    public static void hideSoftKeyboard(Activity activity, View view) {

        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            //Find the currently focused view, so we can grab the correct window token from it.
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = new View(activity);
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 숫자를 통화 단위로 바꾼다. ex) 10000 -> 10,000
     *
     * @param number 숫자값
     * @return 콤마가 추가된 문자열
     */
    public static String convertCurrency(int number) {
        String strNumber = String.valueOf(number);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(10);
        strNumber = nf.format(number);

        return strNumber;
    }


    /****************************
     *
     * 형식 체크 클래스
     *
     ****************************/
    public static class PatternChecker{

        public static boolean isIdPattern(String str) {

            boolean result = true;

            try {

                if (str.length() < 5 || str.length() > 20) {
                    return false;
                }

                for (int i = 0; i < str.length(); i++) {

                    char c = str.charAt(i);

                    if (isLowLetter(c) || isUpperLetter(c) || isNumber(c)) {

                    } else {
                        result = false;
                        break;
                    }
                }

            } catch (Exception e) {
                TLog.e(e.getMessage());
            }

            return result;
        }

        /**
         * 현대모비스 비밀번호 형식
         * 8자 이상, 영문 대/소문자, 특수문자, 숫자 중 3가지 이상 조합
         */
        public static boolean isPwdPattern(String str){

            boolean result = false;

            boolean isLeng = false;
            boolean isEngllish = false;
            boolean isSpecial = false;
            boolean isNumber = false;

            try{

                if(str.length() >= 8){
                    isLeng = true;
                }

                for (int i = 0; i < str.length() ; i++){

                    char c = str.charAt(i);
                    if(isNumber(c)){
                        isNumber = true;
                    }

                    if(isSpecialChar(c)){
                        isSpecial = true;
                    }

                    if(isLowLetter(c) || isUpperLetter(c)){
                        isEngllish = true;
                    }
                }

                int count = 0;
                if(isLeng) count += 1;
                if(isEngllish) count += 1;
                if(isSpecial) count += 1;
                if(isNumber) count += 1;

                if(count >= 3){
                    result = true;
                }

            }catch (Exception e){
                e.printStackTrace();
            }

            return result;
        }

        // 영어와 숫자가 아니면 false
        public static boolean isEnNum(String str){
            boolean result = true;

            try{

                for (int i = 0; i < str.length() ; i++){

                    char c = str.charAt(i);
                    if(isNumber(c)){

                    } else if(isLowLetter(c) || isUpperLetter(c)){

                    } else {
                        result = false;
                    }
                }


            }catch (Exception e){
                e.printStackTrace();
            }

            return result;
        }

        // 소문자
        private static boolean isLowLetter(char c) {

            if (c >= 0x61 && c <= 0x7A) { // 알파벳 소문자
                return true;
            }

            return false;
        }

        // 대문자
        private static boolean isUpperLetter(char c) {

            if (c >= 0x41 && c <= 0x5A) {
                return true;
            }

            return false;
        }

        // 숫자
        private static boolean isNumber(char c) {

            if (c >= 0x30 && c <= 0x39) {
                return true;
            }

            return false;
        }

        // 특수문자
        private static boolean isSpecialChar(char c) {

            if (c >= 0x21 && c <= 0x2F) { // ! " # $ % & ' ( ) * , - . /
                return true;
            } else if (c >= 0x3A && c <= 0x40) { // : ; < = > ? @
                return true;
            } else if (c >= 0x5B && c <= 0x60) { // [ \ ] ^ _`
                return true;
            } else if (c >= 0x7B && c <= 0x7E) { // { | } ~
                return true;
            }

            return false;
        }

        // _ 포함
        private static boolean isSpecialCharOf_(char c) {

            if (c == 0x5F) {
                return true;
            } else {
                return false;
            }

        }
    }
}

