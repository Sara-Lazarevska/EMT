package finki.ukim.mk.emt.service.impl;

import finki.ukim.mk.emt.model.domain.Country;
import finki.ukim.mk.emt.model.domain.Host;
import finki.ukim.mk.emt.model.CreateDto.HostDTO;
import finki.ukim.mk.emt.repository.CountryRepository;
import finki.ukim.mk.emt.repository.HostRepository;
import finki.ukim.mk.emt.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    @Override
    public HostDTO getHostById(Long id) {
        Host host = hostRepository.findById(id).orElseThrow(() -> new RuntimeException("Host not found"));
        return new HostDTO(host.getName(), host.getSurname(), host.getCountry().getId());
    }

    @Override
    public Host addHost(HostDTO dto) {
        Host host = new Host();
        host.setName(dto.getName());
        host.setSurname(dto.getSurname());
        Country country = countryRepository.findById(dto.getCountryID()).orElseThrow(() -> new RuntimeException("Country not found"));
        host.setCountry(country);
        return hostRepository.save(host);
    }

    @Override
    public Host updateHost(Long id, HostDTO dto) {
        Host host = hostRepository.findById(id).orElseThrow(() -> new RuntimeException("Host not found"));
        host.setName(dto.getName());
        host.setSurname(dto.getSurname());
        Country country = countryRepository.findById(dto.getCountryID()).orElseThrow(() -> new RuntimeException("Country not found"));
        host.setCountry(country);
        return hostRepository.save(host);
    }

    @Override
    public void deleteHost(Long id) {
        hostRepository.deleteById(id);
    }
}
