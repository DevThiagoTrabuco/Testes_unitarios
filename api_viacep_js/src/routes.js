import express from 'express';
import CepController from './controllers/CepController.js';

const router = express.Router();

router.get('/cep/:cep', (req, res) => CepController.getCep(req, res));

export default router;
