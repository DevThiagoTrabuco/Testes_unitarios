import CepService from '../services/CepService.js';

class CepController {
  async getCep(req, res) {
    try {
      const cep = req.params.cep;
      const result = await CepService.getCep(cep);
      if (!result) {
        return res.status(404).json({ message: 'CEP não encontrado' });
      }
      res.json(result);
    } catch (e) {
      res.status(500).json({ message: 'Erro ao consultar CEP' });
    }
  }
}

export default new CepController();
