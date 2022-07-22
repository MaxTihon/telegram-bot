DROP TABLE IF EXISTS telegram_user;
CREATE TABLE telegram_user (
    chat_id bigint,
    is_active boolean
);