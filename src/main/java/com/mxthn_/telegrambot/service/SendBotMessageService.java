package com.mxthn_.telegrambot.service;

/**
 * Service for sending bot-messages
 */
public interface SendBotMessageService {
    /**
     * Send message via telegram-bot
     *
     * @param chatId provided chatId in which messages would be sent.
     * @param message provided message to be sent.
     */
    void sendMessage(Long chatId, String message);
}
