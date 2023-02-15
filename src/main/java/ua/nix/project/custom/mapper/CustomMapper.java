package ua.nix.project.custom.mapper;

public interface CustomMapper<T,R> {
    T toMap(R entity);
}
