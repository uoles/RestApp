package ru.uoles.proj.model;

import java.util.Objects;

public class Entity {

    private Long id;
    private String text;

    public Entity() {
    }

    public Entity(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id) && Objects.equals(text, entity.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
