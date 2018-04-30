package io.apicollab.server.mapper;

import io.apicollab.server.domain.Api;
import io.apicollab.server.dto.ApiDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ApiMapper {

    public ApiDTO toDto(Api api) {
        if (api == null) {
            return null;
        }
        return ApiDTO.builder()
                .apiId(api.getId())
                .name(api.getName())
                .version(api.getVersion())
                .build();
    }

    public Collection<ApiDTO> toDtos(Collection<Api> apis) {
        if (apis == null) {
            return null;
        }
        return apis.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Api toEntity(ApiDTO apiDTO) {
        if(apiDTO == null) {
            return null;
        }
        return Api.builder().name(apiDTO.getName()).version(apiDTO.getVersion()).build();
    }
}