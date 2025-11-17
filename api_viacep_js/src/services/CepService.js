import ViaCepClient from '../clients/ViaCepClient.js';
import Cep from '../models/Cep.js';

class CepService {
  async getCep(cep) {
    const data = await ViaCepClient.getCep(cep);
    if (!data) return null;

    return new Cep({
      cep: data.cep,
      logradouro: data.logradouro,
      complemento: data.complemento,
      unidade: data.unidade,
      bairro: data.bairro,
      localidade: data.localidade,
      uf: data.uf,
      estado: data.estado,
      regiao: data.regiao,
      ibge: data.ibge,
      gia: data.gia,
      ddd: data.ddd,
      siafi: data.siafi
    });
  }
}

export default new CepService();
