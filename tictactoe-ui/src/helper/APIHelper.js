import axios from 'axios';

const API_URL = 'http://localhost:8080/api/tictactoe/v1';

export const apiCall = async (endpoint, method = 'get', data = {}) => {
    try {
        const res = await axios({
            method,
            url: `${API_URL}/${endpoint}`,
            data
        });
        return res.data;
    } catch (error) {
        console.error(error);
        throw error;
    }
};