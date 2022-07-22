package com.mxthn_.telegrambot.repository.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "jr_group_sub")
public class JavaRushGroupSubscription {
    @Id
    private Integer id;
    private String title;
    private String lastArticleId;

    @ManyToMany
    @JoinTable(name = "sub_x_tg_user", joinColumns = @JoinColumn(name = "sub_id"), inverseJoinColumns = @JoinColumn(name = "tg_user_id"))
    @ToString.Exclude
    private List<TelegramUser> users;

    public void addUser(TelegramUser telegramUser) {
        if (isNull(users)) {
            users = new ArrayList<>();
        }
        users.add(telegramUser);
    }

    public List<TelegramUser> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JavaRushGroupSubscription that = (JavaRushGroupSubscription) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
