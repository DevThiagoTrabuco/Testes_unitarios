import axios from 'axios';

class ViaCepClient {
  constructor() {
    this.baseUrl = 'https://viacep.com.br/ws';
  }

  async getCep(cep) {
    const url = `${this.baseUrl}/${cep}/json/`;
    try {
      const resp = await axios.get(url);
      return resp.data;
    } catch (e) {
      throw new Error('Falha ao chamar ViaCEP');
    }
  }
}

export default new ViaCepClient();