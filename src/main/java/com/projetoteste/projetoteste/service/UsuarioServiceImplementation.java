package com.projetoteste.projetoteste.service;

import com.projetoteste.projetoteste.entities.Usuario;
import com.projetoteste.projetoteste.model.UsuarioForm;
import com.projetoteste.projetoteste.model.ViaCepDTO;
import com.projetoteste.projetoteste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
@Service
public class UsuarioServiceImplementation implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ViaCepServiceImplementation viaCepServiceImplementation;
    @Override
    public Usuario insere(UsuarioForm usuarioForm) throws ParseException {
        ViaCepDTO endereco = processarEnderecoPeloCep(usuarioForm.getCep());
        System.out.println(endereco);
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioForm.getNome());
        usuario.setBairro(endereco.getBairro());
        usuario.setCidade(endereco.getLocalidade());
        usuario.setEstado(endereco.getUf());
        usuario.setDocumento(usuarioForm.getDocumento());
        usuario.setIdade(calculaIdade(usuarioForm.getData_nascimento()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleta(Integer id) {
        usuarioRepository.deleteById(id);

    }

    @Override
    public Usuario update(UsuarioForm usuarioForm) throws ParseException {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioForm.getNome());
        usuario.setBairro(usuarioForm.getCep());
        usuario.setCidade(usuarioForm.getCep());
        usuario.setEstado(usuarioForm.getCep());
        usuario.setDocumento(usuarioForm.getDocumento());
        usuario.setIdade(calculaIdade(usuarioForm.getData_nascimento()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscaUsuarioDocumento(String documento) {
        return usuarioRepository.findByDocumento(documento);
    }
    @Override
    public List<Usuario> buscaTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public int calculaIdade(String dataNasc) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataNasc);
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(data);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }
    public ViaCepDTO processarEnderecoPeloCep(String cep){
        return viaCepServiceImplementation.retornaEndereco(cep);
    }
}
