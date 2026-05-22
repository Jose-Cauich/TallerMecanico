package TallerMecanico.service;

import TallerMecanico.dtos.Cliente.ClienteRegisterDTO;
import TallerMecanico.dtos.Cliente.ClienteResponseDTO;
import TallerMecanico.dtos.Cliente.ClienteUpdateDTO;
import TallerMecanico.entity.ClienteEntity;
import TallerMecanico.entity.MecanicoEntity;
import TallerMecanico.enums.Genero;
import TallerMecanico.mapper.ClienteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteServicio {

    @Autowired
    TallerMecanico.repository.ClienteRepository clienteRepository;

    @Autowired
    TallerMecanico.repository.MecanicoRepository mecanicoRepository;

    public List<ClienteResponseDTO> obtenerTodos() {
        return clienteRepository.findAll().stream().map(ClienteMapper::toDtoGet).collect(Collectors.toList());
    }

    public ClienteResponseDTO obtenerPorId(Long id) {
       ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return ClienteMapper.toDtoGet(cliente);
    }

    public ClienteResponseDTO insertarCliente(ClienteRegisterDTO dto) {
        MecanicoEntity mecanicoEntity = mecanicoRepository.findById(dto.getIdMecanico()).orElseThrow(() -> new RuntimeException("Mecánico no encontrado"));
        ClienteEntity nuevoCliente = ClienteMapper.toEntity(dto, mecanicoEntity);

        log.info("Cliente registrado con éxito.");
        return ClienteMapper.toDtoGet(clienteRepository.save(nuevoCliente));
    }

    @Transactional
    public void actualizarCliente(Long id, ClienteUpdateDTO dto) {
        ClienteEntity entity = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        ClienteMapper.updateCliente(dto, entity);
        log.info("Cliente con ID {} actualizado", id);
    }

    @Transactional
    public void desactivarCliente(Long id) {
       ClienteEntity clienteEntity = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteEntity.setActivo(false);
        log.info("Cliente con ID {} desactivado", id);
    }
}
