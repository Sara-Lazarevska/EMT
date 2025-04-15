package finki.ukim.mk.emt.service;

import finki.ukim.mk.emt.model.domain.Host;
import finki.ukim.mk.emt.model.CreateDto.HostDTO;

import java.util.List;

public interface HostService {
    List<Host> getAllHosts();
    HostDTO getHostById(Long id);
    Host addHost(HostDTO dto);
    Host updateHost(Long id, HostDTO dto);
    void deleteHost(Long id);
}
