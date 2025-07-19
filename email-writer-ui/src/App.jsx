import { useState } from 'react'
import './App.css'
import { Box, Button, CircularProgress, Container, FormControl, InputLabel, MenuItem, Select, TextField, Typography } from '@mui/material';
import axios from 'axios';

function App() {
  const [loading, setLoading] = useState(false);
  const [emailContent, setEmailContent] = useState('');
  const [tone, setTone] = useState('');
  const [generatedReply, setGeneratedReply] = useState('');
  const [error, setError] = useState('');

  const handleSubmit=async()=>{
      setLoading(true);
      setError('');
      try {
        const response= await axios.post("http://localhost:8080/api/v1/do-request-email-content",{
          emailContent,tone
        });
        setGeneratedReply(typeof response.data=== 'string'?response.data:JSON.stringify(response.data));
      } catch (error) {
        setError('Failed to generate email reply. Please try again sometimes!')
        console.error(error);
      }finally{
        setLoading(false);
      }
  }

  return (
    <>
    <Box
      sx={{
        backgroundColor: '#fff',
        borderRadius: 4, // 4 = 32px
        padding: { xs: 4, md: 6 }, // Responsive padding
        boxShadow: 4,
        // textAlign: 'center',
        maxWidth: '100%',
        margin: '10px auto',
        minHeight: '50px', // Makes the box visibly tall
      }}
    >

      <Typography
      variant="h4"
      component="h4"
      align="center"
      sx={{mb:2,
        fontWeight: 'bold',
        color: 'primary.main',
        letterSpacing: 1.2,
        textShadow: '1px 1px 1px rgba(0,0,0,0.2)',
        transition: 'all 0.2s ease-in-out',
        cursor: 'pointer',
        '&:hover': {
          color: '#2196f3', // Blue glow color ✉️
          textShadow: '0 0 2px #2196f3, 0 0 2px #2196f3',
        },
      }}
      >
      Reply Flow AI
      </Typography>

      <Box sx={{mx:3}}>
        <TextField 
        fullWidth
        multiline
        rows={6}
        variant='outlined'
        label="Original Email Content"
        value={emailContent||''}
        onChange={(e)=>setEmailContent(e.target.value)}
        sx={{mb:2}}/>
        <FormControl fullWidth sx={{mb:2}}>
          <InputLabel>Tone (Optional)</InputLabel>
          <Select
          value={tone || ''}
          label={"Tone (Optional)"}
          onChange={(e)=>setTone(e.target.value)}>
            <MenuItem value="">None</MenuItem>
            <MenuItem value="professional">Professional</MenuItem>
            <MenuItem value="casual">Casual</MenuItem>
            <MenuItem value="friendly">Friendly</MenuItem>
          </Select>
        </FormControl>

        <Button variant='contained' 
          onClick={handleSubmit}
          disabled={!emailContent||loading}
          fullWidth>
          {loading ? <CircularProgress size={20}/> : 'Generate Reply'}
          </Button>
      </Box>

      {error && <Typography color='error' align='center' sx={{mb:2,mt:2}}>{error}</Typography>}

      {generatedReply &&(
        <Box sx={{mt:5,ml:3}}>
          <Typography variant='h6' gutterBottom  sx={{fontWeight: 'bold'}} >Generated Reply</Typography>
          <TextField
          fullWidth
          multiline
          rows={6}
          variant='outlined'
          value={generatedReply || ''}
          slotProps={{
            htmlInput: { readOnly: true }}}/>
          <Button variant='outlined' sx={{mt:2}} onClick={()=> navigator.clipboard.writeText(generatedReply)}>
            Copy to clipboard
          </Button>
        </Box>
      )}
      </Box>
    </>
  )
}

export default App
