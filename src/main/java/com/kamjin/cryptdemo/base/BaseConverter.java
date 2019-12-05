package com.kamjin.cryptdemo.base;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 转换基类
 *
 * @author kamjin1996
 */
public abstract class BaseConverter<E extends BaseEntity, D extends BaseDto> {

    private final Function<D, E> fromDto;

    private final Function<E, D> fromEntity;

    protected BaseConverter(final Function<D, E> fromDto, final Function<E, D> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final E converterFromDto(final D dto) {
        return this.fromDto.apply(dto);
    }

    public final D converterFromEntity(final E entity) {
        return this.fromEntity.apply(entity);
    }

    public final List<E> converterFromDtos(final List<D> dtos) {
        return dtos.stream().map(this::converterFromDto).collect(Collectors.toList());
    }

    public final List<D> converterFromEntitys(final List<E> entitys) {
        return entitys.stream().map(this::converterFromEntity).collect(Collectors.toList());
    }
}
